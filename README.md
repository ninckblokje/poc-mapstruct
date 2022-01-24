# poc-mapstruct

Some proof of concepts for testing and demoing MapStruct.

## Cases

- Simple bean mapping
  - Class: [SimpleMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/SimpleMapping.java)
  - Test: [SimpleMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/SimpleMappingTest.java)
- Dates mapping with function
  - Class: [DatesMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/DatesMapping.java)
  - Test: [DatesMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/DatesMappingTest.java)
- Deep mapping with list and records
  - Class: [DeepRecordMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/DeepRecordMapping.java)
  - Test: [DeepRecordMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/DeepRecordMappingTest.java)
- Mismatch mapping with enum
  - Class: [MismatchMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/MismatchMapping.java)
  - Test: [MismatchMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/MismatchMappingTest.java)
- Conditional mapping (1.4 vs 1.5)
  - Class: [ConditionalMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/ConditionalMapping.java)
  - Test: [ConditionalMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/ConditionalMappingTest.java)
- JAXB with one custom mapping method and JAXBElement<T>
  - Class: [JAXBElementMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/JAXBElementMapping.java)
  - Test: [JAXBElementMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/JAXBElementMappingTest.java)

## Dependency tree

````
ninckblokje.poc.mapstruct:poc-mapstruct:jar:1.0-SNAPSHOT
+- jakarta.xml.bind:jakarta.xml.bind-api:jar:2.3.3:compile
|  \- jakarta.activation:jakarta.activation-api:jar:1.2.2:compile
+- org.mapstruct:mapstruct:jar:1.4.2.Final:compile
+- org.assertj:assertj-core:jar:3.22.0:test
\- org.junit.jupiter:junit-jupiter:jar:5.8.2:test
   +- org.junit.jupiter:junit-jupiter-api:jar:5.8.2:test
   |  +- org.opentest4j:opentest4j:jar:1.2.0:test
   |  +- org.junit.platform:junit-platform-commons:jar:1.8.2:test
   |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
   +- org.junit.jupiter:junit-jupiter-params:jar:5.8.2:test
   \- org.junit.jupiter:junit-jupiter-engine:jar:5.8.2:test
      \- org.junit.platform:junit-platform-engine:jar:1.8.2:test
````
