#include <iostream>
using namespace std;

int length(char s[])
{
    int res = 0;
    while (s[res] != '\0')
    {
        res++;
    }
    return res;
}

int main(int argc, char const *argv[])
{
    /* code */
    freopen("input.txt", "r", stdin);

    int T, pos, start, ans, check, tmp;
    char s1[11], s2[1001];

    cin >> T;

    for (int tc = 1; tc <= T; tc++)
    {
        cin >> tmp;
        cin >> s1;
        cin.ignore();
        cin.getline(s2, 1001);

        ans = 0;
        for (int i = 0; i <= length(s2) - length(s1); i++)
        {
            check = 1;
            for (int j = 0; j < length(s1); j++)
            {
                if (s1[j] != s2[i + j])
                {
                    check = 0;
                    break;
                }
            }
            if (check == 1)
                ans++;
        }
        cout << "#" << tc << " " << ans << endl;
    }
    return 0;
}
