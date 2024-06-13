package by.tishalovichm.department.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {

    private final Long resourceId;

    public ResourceNotFoundException(Long resourceId) {
        this.resourceId = resourceId;
    }

}
