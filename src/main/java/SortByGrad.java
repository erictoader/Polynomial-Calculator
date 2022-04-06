import java.util.Comparator;

public class SortByGrad implements Comparator<Monom> {
    @Override
    public int compare(Monom o1, Monom o2) {
        return o2.getGrad() - o1.getGrad();
    }
}
