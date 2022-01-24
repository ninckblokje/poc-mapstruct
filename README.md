# poc-mapstruct

Some proof of concepts for testing and demoing MapStruct.

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
- JAXB with one custom mapping method and JAXBElement<T>
  - Class: [JAXBElementMapping.java](src/main/java/ninckblokje/poc/mapstruct/mapping/JAXBElementMapping.java)
  - Test: [JAXBElementMappingTest.java](src/test/java/ninckblokje/poc/mapstruct/mapping/JAXBElementMappingTest.java)
