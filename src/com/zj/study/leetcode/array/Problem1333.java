package com.zj.study.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zj
 * @desiription:
 * @date 2021/4/20 8:09 下午
 */
public class Problem1333 {
    public static void main(String[] args) {
        int[][] restaurants;
        int veganFriendly;
        int maxPrice;
        int maxDistance;
        Solution solution = new Solution();
        restaurants = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        veganFriendly = 0;
        maxPrice = 50;
        maxDistance = 10;
        System.out.println(solution.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));

        restaurants = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        veganFriendly = 1;
        maxPrice = 50;
        maxDistance = 10;
        System.out.println(solution.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));

        restaurants = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        veganFriendly = 0;
        maxPrice = 30;
        maxDistance = 3;
        System.out.println(solution.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));

    }

    private static class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            List<Restaurant> restaurantList = new ArrayList<>();
            for (int i = 0; i < restaurants.length; i++) {
                Integer id = restaurants[i][0];
                Integer rating = restaurants[i][1];
                Integer vegan = restaurants[i][2];
                Integer price = restaurants[i][3];
                Integer distance = restaurants[i][4];
                if (veganFriendly == 1) {
                    if (vegan == 0) {
                        continue;
                    }
                }
                if (price > maxPrice) {
                    continue;
                }
                if (distance > maxDistance) {
                    continue;
                }
                restaurantList.add(new Restaurant(id, rating));
            }

            Collections.sort(restaurantList, new Comparator<Restaurant>() {
                @Override
                public int compare(Restaurant o1, Restaurant o2) {
                    if (!o1.rating.equals(o2.rating)) {
                        return o2.rating - o1.rating;
                    } else {
                        return o2.id - o1.id;
                    }
                }
            });
            return restaurantList.stream().map(temp -> temp.id).collect(Collectors.toList());
        }


        private static class Restaurant {
            private Integer id;
            private Integer rating;

            public Restaurant(Integer id, Integer rating) {
                this.id = id;
                this.rating = rating;
            }
        }
    }
}
