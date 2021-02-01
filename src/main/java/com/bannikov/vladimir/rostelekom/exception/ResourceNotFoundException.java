package com.bannikov.vladimir.rostelekom.exception;

public class ResourceNotFoundException extends RostelekomApplicationException {

    private final Class<?> resourceClass;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceClass = null;
    }

    public ResourceNotFoundException(String message, Class<?> resourceClass) {
        super(message);
        this.resourceClass = resourceClass;
    }

    public Class<?> getResourceClass() {
        return resourceClass;
    }
}
