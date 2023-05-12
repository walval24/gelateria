package it.gelaterialacarraia.gelateria.presentation.dtos;

public class ProductDTO {

    private long id;
    private String name;
    private boolean isDairyFree;
    private boolean isNutfree;
    private boolean isVegan;
    private  byte [] cover;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDairyFree() {
        return isDairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        isDairyFree = dairyFree;
    }

    public boolean isNutfree() {
        return isNutfree;
    }

    public void setNutfree(boolean nutfree) {
        isNutfree = nutfree;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}

/*In Java, l'entità specifica (entity) rappresenta un oggetto che mappa i dati di una tabella di un database.
 Solitamente, ogni entità specifica ha una corrispondente tabella nel database. Le entità specifiche sono utilizzate
 per interagire con il database, ovvero per recuperare, aggiornare o eliminare i dati.
Il DTO (Data Transfer Object), d'altra parte, rappresenta un oggetto utilizzato per trasferire dati tra i diversi strati
dell'applicazione, ad esempio tra la logica di business e la presentazione. Il DTO è un oggetto che contiene solo i dati necessari
per una determinata operazione e non contiene alcuna logica o comportamento.
Il DTO può essere utilizzato per ridurre la quantità di dati che devono essere trasmessi tra i diversi strati dell'applicazione,
 migliorando così le prestazioni.
La principale differenza tra un'entità specifica e un DTO è che l'entità specifica contiene informazioni sullo stato dell'oggetto
e sulla sua posizione all'interno del database, mentre il DTO contiene solo i dati necessari per una determinata operazione
e non contiene alcuna informazione sullo stato dell'oggetto.
Inoltre, le entità specifiche spesso contengono annotazioni e metodi specifici per interagire con il database,
mentre i DTO sono solitamente oggetti semplici, composti solo da dati e senza alcuna annotazione o metodo specifico per il database.*/
