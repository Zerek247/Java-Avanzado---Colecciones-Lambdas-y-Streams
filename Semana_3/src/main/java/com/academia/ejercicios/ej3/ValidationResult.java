package com.academia.ejercicios.ej3;

import java.util.ArrayList;
import java.util.List;

record ValidationResult(boolean isValid, List<String> errors) {
    static ValidationResult valid() {
        return new ValidationResult(true, List.of());
    }

    static ValidationResult invalid(String... errors) {
        return new ValidationResult(false, List.of(errors));
    }

    // Combina dos resultados acumulando errores
    ValidationResult merge(ValidationResult other) {
        if (this.isValid && other.isValid) return valid();

        List<String> allErrors = new ArrayList<>(this.errors);
        allErrors.addAll(other.errors);

        return new ValidationResult(false, allErrors);
    }
}
