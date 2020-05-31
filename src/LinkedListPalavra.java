public class LinkedListPalavra {
    private class Node {

        public Palavra palavra;
        public Node next;

        public Node(Palavra palavra) {
            this.palavra = palavra;
            next = null;
        }


        public Node(Palavra palavra, Node next) {
            this.palavra = palavra;
            this.next = next;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    /**
     * Construtor da lista.
     */
    public LinkedListPalavra() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     *
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     *
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param palavra elemento a ser adicionado ao final da lista
     */
    public void add(Palavra palavra) { // O(1)
        Node n = new Node(palavra);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     *
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            return tail.palavra;
        }

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.palavra);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            s.append(aux.palavra.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Insere um elemento em uma determinada posicao da lista.
     *
     * @param index a posicao da lista onde o elemento sera inserido
     * @param palavra elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Palavra palavra) {
        // Considerar 3 situacoes:
        // insercao no inicio (lista vazia ou nao), no meio, no fim

        // Primeiro: verificar se o índice é válido
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node n = new Node(palavra);

        if (index == 0) {// Insercao no inicio
            if (count == 0) // se a lista estiver vazia
            {
                tail = n;
            } else {
                n.next = head;
            }
            head = n;
        } else if (index == count) {// Insercao no fim
            tail.next = n;
            tail = n;
        } else { // Insercao no meio
            Node ant = head;
            for (int i = 0; i < index - 1; i++) {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }
        count++;
    }



    public void addEmOrdem(Palavra novaPalavra){
        if(count==0) add(novaPalavra);
        else if(novaPalavra.getPalavra().compareTo(get(0).getPalavra())<0){
            add(0, novaPalavra);
        }
        else if (novaPalavra.getPalavra().compareTo(tail.palavra.getPalavra())>0){
            add(novaPalavra);
        }
        else{
            for(int i = 0; i<count; i++){
                if(novaPalavra.getPalavra().compareTo(get(i).getPalavra())>0){
                    add(novaPalavra);
                    break;
                }
            }
        }
    }


    public void mostra(){
        String str = " ";
        for(int i =0; i<count; i++){
            Node n = head;
            str = str + n.palavra.getPalavra();
        }
        System.out.println(str);
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     *
     * @param index a posicao da lista
     * @param palavra o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra set(int index, Palavra palavra) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            Palavra s = tail.palavra;
            tail.palavra = palavra;
            return s;
        }

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        Palavra p = aux.palavra;
        aux.palavra = palavra;
        return p;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     *
     * @param palavra o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Palavra palavra) {
        if (count == 0) // se lista vazia
            return false;

        if (head.palavra.equals(palavra)) { // remocao do primeiro
            head = head.next;
            if (count == 1) { // se houver somente um elemento na lista
                tail = null;
            }
            count--;
            return true;
        }

        Node ant = head;
        Node aux = head.next;
        while (aux != null) {
            if (aux.palavra.equals(palavra)) { // encontrou o elemento a ser removido
                if (aux == tail) { // remocao do ultimo
                    tail = ant;
                    tail.next = null;
                } else { // remocao do meio
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            ant = ant.next;
            aux = aux.next;
        }

        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     *
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = head;
        if (index == 0) { // remocao do primeiro elemento da lista
            if (tail == head) // se tiver apenas um elemento
                tail = null;
            head = head.next;
            count--;
            return aux.palavra;
        }
        int c = 0;
        while (c < index - 1) {
            aux = aux.next;
            c++;
        }
        Palavra p = aux.next.palavra;
        if (tail == aux.next) // se remocao do ultimo elemento da lista
            tail = aux;
        aux.next = aux.next.next;
        count--;
        return p;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     *
     * @param palavra o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(String palavra) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.palavra.equals(palavra)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     *
     * @param palavra o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(String palavra) { // O(n)
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.palavra.getPalavra().equals(palavra)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Palavra[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException("Índices inválidos!");
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex deve ser menor que toIndex!");

        Palavra []a = new Palavra[toIndex-fromIndex];
        Node aux = head;
        for (int i = 0; i < fromIndex; i++) { // para "chegar" ate a posicao fromIndex
            aux = aux.next;
        }
        int pos = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            a[pos] = aux.palavra;
            aux = aux.next;
            pos++;
        }
        return a;
    }
}
