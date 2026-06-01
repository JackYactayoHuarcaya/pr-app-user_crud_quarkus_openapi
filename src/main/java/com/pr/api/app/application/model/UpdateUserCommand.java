package com.pr.api.app.application.model;

import java.util.UUID;

public record UpdateUserCommand(UUID id, String name, int age, int code) {
}
