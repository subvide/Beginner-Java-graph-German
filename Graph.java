class Graph{

    private static final int n = 10;
    private int[][] adj = new int[n][n];
    private char[] knot = new char[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

    public Graph()
    {
        init();
    }

    private void init()
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                adj[j][i] = adj[i][j];
            }
        }
    }

    int findIndex(char c)
    {
        int i = -1;
        for (int j=0; j<n; j++)
        {
            if (c == knot[j])
            {
                i = j;
                break;
            }
        }
        return i;
    }

    char findChar(int k)
    {
        return knot[k];
    }

    private boolean istbesucht(char k, char[] arr)
    {
        for (int i=0; i<n; i++)
        {
            if (arr[i] == k)
            {
                return true;
            }
        }
        return false;
    }

    public void startbreitensuche(char s)
    {
        int pos = findIndex(s);
        char[] besucht = new char[n];
        besucht[0] = knot[pos];
        besucht = breitensuche(besucht, pos);
        System.out.println(besucht);
    }

    private char[] breitensuche(char[] besucht, int pos)
    {
        for (int i=0; i<n; i++)
        {
            if (adj[pos][i]>0){
                for (int k=0; k<n; k++)
                {
                    if (besucht[k] == knot[i])
                    {
                        break;
                    }
                    else
                    {
                        if (k==n-1)
                        {
                            for (int j=0; j<n; j++)
                            {
                                if (besucht[j] == 0)
                                {
                                    besucht[j] = knot[i];
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        for (int i=0; i<n; i++)
        {
            if (besucht[i] == knot[pos])
            {
                besucht = breitensuche(besucht, findIndex(besucht[i+1]));
            }
        }
        return besucht;
    }

    public void starttiefensuche(char c)
    {
        int pos = findIndex(c);
        char[] besucht = new char[n];
        besucht = tiefensuche(besucht, pos);
        System.out.println(besucht);
    }

    private char[] tiefensuche(char[] besucht, int pos)
    {
        besucht[0] = knot[pos];

        for(int j=0; j<n; j=j++)
        {
            if(adj[pos][j]>0)
            {
                for(int k=0; k<n; k=k++)
                {
                    if(besucht[k] == knot[j])
                    {
                        break;
                    } 
                    else
                    {
                        tiefensuche(besucht,j);
                    }
                }
            }
        }
        return besucht;
    }
}
