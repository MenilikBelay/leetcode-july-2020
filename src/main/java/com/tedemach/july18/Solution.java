package com.tedemach.july18;

import java.util.*;

class Solution {
    int index;
    int[] courseOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses;
        courseOrder = new int[numCourses];
        HashMap<Integer, Vertex> vertices = new HashMap<>();
        populateGraph(prerequisites, vertices);
        try {
            for (int i = 0; i < prerequisites.length; i++) {
                setOrder(vertices, prerequisites[i][0]);
                setOrder(vertices, prerequisites[i][1]);
            }
        } catch (CycleExistsException e) {
            return new int[] {};
        }
        return courseOrder;
    }

    private void populateGraph(int[][] prerequisites, HashMap<Integer, Vertex> vertices) {
        for (int i = 0; i < prerequisites.length; i++) {
            int v_int = prerequisites[i][0];
            int u_int = prerequisites[i][1];
            Vertex u = vertices.getOrDefault(u_int, new Vertex(u_int));
            Vertex v = vertices.getOrDefault(v_int, new Vertex(v_int));
            u.addNeighbour(v);
            vertices.put(u_int, u);
            vertices.put(v_int, v);
        }
    }

    public void setOrder(HashMap<Integer, Vertex> courses, int course) throws CycleExistsException {
        if (index < 0 || isVisited(courses, course))
            return;
        Vertex v = courses.get(course);
        v.status = STATUS.VISITING;
        for (Vertex u : v.vertices) {
            setOrder(courses, u.value);
        }
        v.status = STATUS.VISITED;
        courseOrder[index] = course;
        index--;
    }

    private boolean isVisited(HashMap<Integer, Vertex> courses, int course) throws CycleExistsException {
        Vertex v = courses.get(course);
        if (v.status == STATUS.VISITING)
            throw new CycleExistsException();
        return v.status == STATUS.VISITED;
    }

    public class CycleExistsException extends Exception {

    }

    enum STATUS {
        VISITED, VISITING, UNVISITED
    };

    class Vertex {
        int value;
        List<Vertex> vertices;
        STATUS status;

        public Vertex(int value) {
            this.value = value;
            vertices = new ArrayList<>();
            status = STATUS.UNVISITED;
        }

        public void addNeighbour(Vertex neighbour) {
            vertices.add(neighbour);
        }
    }
}

/*
 * 
 * HashMap<Integer, Vertex> vertices;
 * 
 * // visit every combination 1. Create a new vertex if not in vertices 2.
 * insert the neighbour vertex if found/not 3. update vertices
 * 
 * 
 * 
 * class Vertex { public static enum STATUS = {VISITED, VISITING, UNVISITED};
 * int value; List<Vertex> vertices; Status status;
 * 
 * public Vertex (int value) { this.value = value; vertices = new ArrayList<>();
 * status = STATUS.UNVISITED; }
 * 
 * public void addNeighbour(Vertex neighbour) { vertices.add(neighbour); } }
 * 
 * 
 * 
 * 
 */