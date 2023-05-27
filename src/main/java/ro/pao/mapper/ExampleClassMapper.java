//package ro.pao.mapper;
//
//
//import ro.pao.model.enums.EnumExample;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public class ExampleClassMapper {
//
//    private static final ExampleClassMapper INSTANCE = new ExampleClassMapper();
//
//    private ExampleClassMapper() {
//    }
//
//    public static ExampleClassMapper getInstance() {
//        return INSTANCE;
//    }
//
//
//    public Optional<ExampleClass> mapToExampleClass(ResultSet resultSet) throws SQLException {
//        if (resultSet.next()) {
//            return Optional.of(
//                    ExampleClass.builder()
//                    .id(UUID.fromString(resultSet.getString(1)))
//                    .exampleDoubleField(resultSet.getDouble(2))
//                    .exampleIntField(resultSet.getInt(3))
//                    .exampleFloatField(resultSet.getFloat(4))
//                    .exampleStringField(resultSet.getString(5))
//                    .enumExample(EnumExample.valueOf(resultSet.getString(6)))
//                    .build()
//            );
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    public List<ExampleClass> mapToExampleClassList(ResultSet resultSet) throws SQLException {
//        List<ExampleClass> exampleClassList = new ArrayList<>();
//        while (resultSet.next()) {
//            exampleClassList.add(
//                    ExampleClass.builder()
//                            .id(UUID.fromString(resultSet.getString(1)))
//                            .exampleDoubleField(resultSet.getDouble(2))
//                            .exampleIntField(resultSet.getInt(3))
//                            .exampleFloatField(resultSet.getFloat(4))
//                            .exampleStringField(resultSet.getString(5))
//                            .enumExample(EnumExample.valueOf(resultSet.getString(6)))
//                            .build()
//            );
//        }
//
//        return exampleClassList;
//    }
//}
