package ra.bussiness.designe;

public  interface IProduc<T> {
    T inputData();
    void addData();
    void edit();
    void deleteData();
    void display();
    void sortByprofit();
    void switchStatus();
    void findByName();
};
