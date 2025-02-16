package com.example.staticTesting.Example;

class ServiceA {
    public boolean isFeatureEnabled() {
        return "enabled".equals(GlobalConfig.getConfig());
    }
}