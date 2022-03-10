package rip.hippo.spigotmenu.function;

/**
 * @author Hippo
 */
public interface TriConsumer<T,U,S> {
  void accept(T first, U second, S third);
}
