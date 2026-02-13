package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {
    
    public double[] add(double[] v1, double[] v2) {
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension.");
        }

        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }

        return result;
    }

    public double[] subtract(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vector lengths must match");
        }

        double[] result = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }

        return result;
    }

    public double[] multiply(double[] v1, int x) {
        return new double[] { v1[0] * x, v1[1] * x, v1[2] * x };
    }
    
    public double dotProduct(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return 0.0;
    }
    
    public double[] norm(double[] v1) {
        double magnitude = 0;

        for (double component : v1) {
            magnitude += component * component;
        }
        magnitude = Math.sqrt(magnitude);

        if (magnitude == 0.0) {
            return new double[v1.length];
        }

        double[] normalisedVector = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            normalisedVector[i] = v1[i] / magnitude;
        }

        return normalisedVector;
    }
}