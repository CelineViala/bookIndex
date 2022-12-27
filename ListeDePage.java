public class ListeDePage {
    protected int numeroPage;
    protected ListeDePage next;

    public ListeDePage(int numero) {
        this.numeroPage = numero;
        this.next = null;
    }
}
