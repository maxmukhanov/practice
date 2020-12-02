package com.max.practice.excercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/largest-component-size-by-common-factor/
public class LargestComponentSizeByCommonFactor {

    class UF {
        final int [] parent;
        final int [] count;

        int largest;

        UF(int n) {
            parent = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            Arrays.fill(count, 1);
        }

        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if (p1 != p2) {
                parent[p1] = p2;
                count[p2] += count[p1];

            }
            largest = Math.max(largest, count[p2]);
        }

        int find(int p) {
            if (parent[p] != p) {
                p = find(parent[p]);
            }
            return p;
        }

    }

    public int largestComponentSize(int[] A) {
        int n = A.length;

        UF uf = new UF(n);

        Set<Integer> primes = allprimes();
        int [] primeToIndex = new int[100_001];
        Arrays.fill(primeToIndex, -1);
        for(int i = 0; i < n; i++) {
            int a = A[i];
            for(int p : primes) {
                if (primes.contains(a)) {
                    p = a;
                }

                if (a % p == 0) {
                    if (primeToIndex[p] > -1) {
                        uf.union(primeToIndex[p], i);
                    }
                    primeToIndex[p] = i;
                }

                while(a%p == 0) {
                    a /= p;
                }

                if (a == 1) break;
            }
        }

        return uf.largest;
    }

    Set<Integer> allprimes() {
        Set<Integer> primes = new HashSet<>();
        boolean [] isPrime = new boolean[100_001];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= 100_000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for(int j = 2; i*j <= 100_000; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        return primes;
    }
}
