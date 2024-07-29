/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

/**
 * Interface representing an animal that can live both in aquatic and terrestrial environments.
 * Provides methods to get and set the number of legs of the animal.
 */
public interface IAquaticTerrestrial {
    /**
     * The default number of legs for an aquatic-terrestrial animal.
     */
    int noLegs = 4;

    /**
     * Gets the number of legs of the animal.
     *
     * @return the number of legs
     */
    int getNoLegs();

    /**
     * Sets the number of legs of the animal.
     *
     * @param noLegs the number of legs to set
     */
    void setNoLegs(int noLegs);
}
