package structural.decoratorPattern;

import structural.decoratorPattern.decorators.CompressionDecorator;
import structural.decoratorPattern.decorators.DataSource;
import structural.decoratorPattern.decorators.DataSourceDecorator;
import structural.decoratorPattern.decorators.EncryptionDecorator;
import structural.decoratorPattern.decorators.FileDataSource;

public class Main {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("Main.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("Main.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
