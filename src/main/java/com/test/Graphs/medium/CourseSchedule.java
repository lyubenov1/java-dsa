package com.test.Graphs.medium;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses ; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites){
            adjList[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];

        for(int i = 0; i < numCourses ; i++){
            if(!visited[i]) {
                if(cycleDetect(i, adjList, visited, dfsVisited)) return false;
            }
        }
        return true;
    }
    public static boolean cycleDetect(int idx, ArrayList<Integer>[] adjList, boolean[] visited, boolean[] dfsVisited){
        if(!visited[idx]) {
            visited[idx] = true;
            dfsVisited[idx] = true;
            for (int i : adjList[idx]) {
                if(cycleDetect(i, adjList, visited, dfsVisited)) return true;
            }
            dfsVisited[idx] = false;
        } else return dfsVisited[idx];

        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result);
    }
}