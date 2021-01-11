/*
package SokoOLD;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

import java.util.AbstractMap;
import java.util.Map;

*/
/**
 * @author: Callum Jenkins
 * 04/01/2021
 * <p>
 * Class: Builder
 *//*


public class ProgramBuilder implements BuilderFactory{

    private JavaFXBuilderFactory defaultBuilderFactory = new JavaFXBuilderFactory();

    public static class SimpleEntryBuilder<K, V> implements Builder<Map.Entry<K, V>> {

        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public Map.Entry<K, V> build() {
            Map.Entry<K, V> picker = new AbstractMap.SimpleEntry<K, V>(key, value);
            return picker;
        }
    }

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        return (type == Map.Entry.class) ? new SimpleEntryBuilder()
                : defaultBuilderFactory.getBuilder(type);
    }

}
*/
