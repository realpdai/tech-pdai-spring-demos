package tech.pdai.springboot.postgre.jpa.druid.constants;

/**
 * @author pdai
 */
public final class PGConstants {

    /**
     * unique id generator class.
     */
    public static final String ID_GENERATOR_CONFIG = "org.hibernate.id.IncrementGenerator";

    /**
     * id generator.
     */
    public static final String ID_GENERATOR = "idGenerator";

    /**
     * no instance.
     */
    private PGConstants() {
    }

}
