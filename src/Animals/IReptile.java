/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

/**
 * Interface representing a Reptile.
 */
public interface IReptile {
    /**
     * The maximum speed a reptile can achieve.
     */
    static final int MAX_SPEED = 5;

    /**
     * Increases the speed of the reptile.
     *
     * @param speeder the amount to increase the speed by
     * @return true if the speed was increased successfully, false otherwise
     */
    boolean speedUp(int speeder);
}
