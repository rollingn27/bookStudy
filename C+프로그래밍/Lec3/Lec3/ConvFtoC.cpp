#include <iostream>
using namespace std;

// È­¾¾¿Âµµ¸¦ ¼·¾¾¿Âµµ·Î º¯È¯ÇÏ´Â ÇÔ¼ö
// ¸Å°³º¯¼ö float fahr: È­¾¾¿Âµµ
// ¹ÝÈ¯°ª   ¼·¾¾¿Âµµ(float)
float FahrToC(float fahr)
{
    return (fahr - 32) * 5 / 9;
}

int main()
{
    float fTemp, cTemp;

    cout << "È­¾¾¿Âµµ: ";
    cin >> fTemp;
    cTemp = FahrToC(fTemp);
    cout << "------> ¼·¾¾ ¿Âµµ: " << cTemp << endl;
    return 0;
}