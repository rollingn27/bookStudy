#include <iostream>
using namespace std;

struct SalesRec
{
    char pID[10];
    int dYear, dMonth, dDate;
    char deliverAddr[40];
};

void PrSalesRec(const SalesRec& sRec);

int main()
{
    SalesRec s = { "C25TV001", 2019, 11, 15, "����� ���α� ���з�86" };
    PrSalesRec(s);    
    return 0;
}

// sRec�� ��� ���� �μ�
void PrSalesRec(const SalesRec& sRec)
{    
    cout << "ǰ���ڵ�: " << sRec.pID << endl;
    cout << "�������: " << sRec.dYear << "�� ";
    cout << sRec.dMonth << "�� ";
    cout << sRec.dDate << "��" << endl;
    cout << "����ּ�: " << sRec.deliverAddr << endl;
}