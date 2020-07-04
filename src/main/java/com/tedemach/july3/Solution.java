package com.tedemach.july3;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {

        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            rotateCell(cells);
        }
        return cells;

        /**
         * if (cells == null) return cells; rotateCell (cells); int[] first = new
         * int[cells.length]; first = Arrays.copyOf(cells, cells.length); int cycle = 1;
         * N--; while (N > 0) { rotateCell(cells); cycle++; if (Arrays.equals(cells,
         * first)) { N = N % cycle; } else { N--; } } return cells;
         **/
    }

    private void rotateCell(int[] cells) {
        if (cells == null)
            return;
        int cache = cells[0]; // the first value as cache
        for (int i = 0; i < cells.length; i++) {
            int newCache = cells[i];
            if (i > 0 && i + 1 < cells.length) {
                cells[i] = cache == cells[i + 1] ? 1 : 0;
            } else {
                cells[i] = 0;
            }
            cache = newCache;
        }
    }
}