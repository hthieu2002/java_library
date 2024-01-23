package Controller;

public class BookGui {
    private String IdBook, NameBook, NameAuthor,PublishDate /* ngày xuất bản */, publishingCompany/* nhà xuất bản*/,Category/* chú thích */,note,dates;
    private int Number;
    public String getIdBook() {
        return IdBook;
    }

    public void setIdBook(String IdBook) {
        this.IdBook = IdBook;
    }

    public String getNameBook() {
        return NameBook;
    }

    public void setNameBook(String NameBook) {
        this.NameBook = NameBook;
    }

    public String getNameAuthor() {
        return NameAuthor;
    }

    public void setNameAuthor(String NameAuthor) {
        this.NameAuthor = NameAuthor;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String PublishDate) {
        this.PublishDate = PublishDate;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }


    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
    
    
}
