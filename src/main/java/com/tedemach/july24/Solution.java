package com.tedemach.july24;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<List<Integer>> result;
    List<Integer> forwardCache;
    int[][] graph;
    int target; // last element

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null)
            return null;
        this.graph = graph;
        target = graph.length - 1;
        result = new ArrayList<>();
        forwardCache = new ArrayList<>();
        forwardCache.add(0); // since this is the begining
        DFS(0);
        return result;
    }

    private void DFS(int index) {
        if (index == target) {
            // congra we are there
            result.add(new ArrayList<>(forwardCache));
            return;
        }
        for (int i = 0; i < graph[index].length; i++) {
            forwardCache.add(graph[index][i]);
            DFS(graph[index][i]);
            forwardCache.remove(forwardCache.size() - 1);
        }
    }
}