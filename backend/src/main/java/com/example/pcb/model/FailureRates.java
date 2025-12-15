package com.example.pcb.model;

import java.util.Map;

// Model representing the failure rates by board and station

public record FailureRates(Map<String, Map<String, Double>> rates) {}