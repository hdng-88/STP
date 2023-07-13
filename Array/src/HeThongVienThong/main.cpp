#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    freopen("input.txt", "r", stdin);
    int T;
    cin >> T;
    int rs[] = {0, 0, 1, -1};
    int cs[] = {1, -1, 0, 0};
    for (int t = 1; t <= T; t++)
    {

        int ans = 0;
        char s[101][101];
        int M, N;
        cin >> M >> N;
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                cin >> s[i][j];
            }
        }
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (s[i][j] == 'A')
                {
                    int r = i;
                    int c = j;

                    for (int k = 0; k < 4; k++)
                    {
                        int cr = r + rs[k];
                        int cc = c + cs[k];

                        if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc] == 'H')
                        {
                            s[cr][cc] = 'X';
                        }
                    }
                }

                else if (s[i][j] == 'B')
                {
                    int r = i;
                    int c = j;

                    for (int k = 0; k < 4; k++)
                    {
                        int count = 2;
                        int cr = r;
                        int cc = c;
                        while (count-- > 0)
                        {
                            cr += rs[k];
                            cc += cs[k];

                            if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc] == 'H')
                            {
                                s[cr][cc] = 'X';
                            }
                        }
                    }
                }

                else if (s[i][j] == 'C')
                {
                    int r = i;
                    int c = j;

                    for (int k = 0; k < 4; k++)
                    {
                        int count = 3;
                        int cr = r;
                        int cc = c;
                        while (count-- > 0)
                        {
                            cr += rs[k];
                            cc += cs[k];

                            if (cr >= 0 && cr < M && cc >= 0 && cc < N && s[cr][cc] == 'H')
                            {
                                s[cr][cc] = 'X';
                            }
                        }
                    }
                }
            }
        }
    }
    return 0;
}