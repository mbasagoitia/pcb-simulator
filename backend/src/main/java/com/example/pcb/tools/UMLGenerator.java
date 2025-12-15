package com.example.pcb.tools;

import de.elnarion.util.plantuml.generator.classdiagram.PlantUMLClassDiagramGenerator;
import de.elnarion.util.plantuml.generator.classdiagram.config.PlantUMLClassDiagramConfigBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.List;

// Run with mvn exec:java -Dexec.mainClass="com.example.pcb.tools.UMLGenerator"

public class UMLGenerator {

    public static void main(String[] args) throws Exception {

        List<String> packagesToScan = List.of(
                "com.example.pcb"
        );

        // Classes to hide
        List<String> hideClasses = List.of(
            "com.example.pcb.tools"
        );

        // Build config
        PlantUMLClassDiagramConfigBuilder configBuilder =
                new PlantUMLClassDiagramConfigBuilder(packagesToScan)
                        .withHideClasses(hideClasses);

        // Create generator
        PlantUMLClassDiagramGenerator generator =
                new PlantUMLClassDiagramGenerator(configBuilder.build());

        // Generate PlantUML text
        String diagram = generator.generateDiagramText();

        Files.writeString(Path.of("diagram.puml"), diagram, StandardCharsets.UTF_8);

        System.out.println("Generated diagram.puml");
    }
}
