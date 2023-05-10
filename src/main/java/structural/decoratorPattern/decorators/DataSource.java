package structural.decoratorPattern.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
