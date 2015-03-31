package lab1_2015;


import java.lang.reflect.Method;

/**
 * Created by Yaroslav on 12.02.2015.
 */




public class lab1
{
    public static final float EPSILON = 1.19209290E-07F;
    public static void funk(float[]x,float[]fsv)
    {
        float e= 5;
        double r=0.4e3,i01=10e-9,i02=2e-9,m1=2,m2=1.8,Ft=26e-3;
        int k =0;


            fsv[0] = (float) (i01 * (Math.exp((x[0]) / (m1 * Ft)) - 1) - i02 * (Math.exp((x[1]) / (m2 * Ft)) - 1));
            fsv[1] = (float) (x[0] + x[1] + i01 * (Math.exp((x[0]) / (m1 * Ft)) - 1) * r - e);
            k++;
            System.out.printf("       Визов функції %d", k);

    }

    static void newton(float[] x, float EPS, int n)
    {

        float[]  dxv=new float[n];
        float[]fsv=new float[n];
        float[] fhsv=new float[n];
        float[][] jm=new float[n][n];
        double h, normx, normdx;
        int i, j, p, k=0;

        do
        {


            if(k!=0){
                System.out.printf("\n\n\nk=%d",k);
                for (i=0;i<n;i++)
                    System.out.printf("\nx[%d]=%f, f[%d]=%f\n",i,x[i],i,fsv[i]);
            }
            normx=0;
            normdx=0;
            for(j=0; j<n; j++)
            {   h=Math.sqrt(EPSILON)*x[j];
                if(0==h)
                    h=Math.sqrt(EPSILON);

                funk(x,fhsv);

                x[j]-=h;
                for(i=0;i<n;i++)
                {
                    jm[i][j]=(float)(-(fhsv[i]-fsv[i])/h);
                }
            }



            for(j=0;j<n;j++)
            {
                for(i=j;i<n;i++)
                {
                    for(p=0;p<j;p++)
                    {
                        jm[i][j] -= jm[i][p]*jm[p][j];
                    }
                }
                for(i=j+1;i<n;i++)
                {
                    for(p=0;p<j;p++)
                    {
                        jm[j][i]-=jm[j][p]*jm[p][i];
                    }
                    jm[j][i]=jm[j][i]/jm[j][j];

                }
            }
            for(i=0;i<n;i++)
            {
                dxv[i]=fsv[i];
                for(j=0;j<i;j++)
                {
                    dxv[i]-=jm[i][j]*dxv[j];
                }
                dxv[i]=dxv[i]/jm[i][i];
            }
            for(i=(n-1);i>=0;i--)
            {
                for(j=(i+1);j<n;j++)
                {
                    dxv[i]=dxv[i]-jm[i][j]*dxv[j];
                }
            }


            for(i=0;i<n;i++)
            {
                x[i]+=dxv[i];
            }


            for(i=0;i<n;i++)
            {
                normx+=x[i]*x[i];
                normdx+=dxv[i]*dxv[i];
            }
            normx=Math.sqrt(normx);
            normdx=Math.sqrt(normdx);

            k++;
        }
        while(normdx>normx*EPS);


    }

    static void sichnyh(float[] x, float EPS, int n)
    {
        float[]  dX=new float[n];
        float[] fsv=new float[n];
        float[] fhsv=new float[n];
        float[][] jm1=new float[n][n];
        float[][] jm=new float[n][n];
        double h, normx, normdx, tmp=0;
        int i, j, p, k=0;

        funk(x, fsv);

        System.out.printf("\n\n\nk=%d",k);
        for (i=0;i<n;i++)
            System.out.printf("\nx[%d]=%f, f[%d]=%f\n",i,x[i],i,fsv[i]);
        k++;
        for(j=0; j<n; j++)
        {   h=Math.sqrt(EPSILON)*x[j];
            if(0==h)
                h=Math.sqrt(EPSILON);
            x[j]+=h;
            funk(x,fhsv);
            x[j]-=h;
            for(i=0;i<n;i++)
            {
                jm[i][j]=(float)(-(fhsv[i]-fsv[i])/h);
            }
        }


        do
        {    normx=0;
            normdx=0;
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    jm1[i][j]=jm[i][j];



            for(j=0;j<n;j++)
            {
                for(i=j;i<n;i++)
                {
                    for(p=0;p<j;p++)
                    {
                        jm1[i][j] -= jm1[i][p]*jm1[p][j];
                    }
                }
                for(i=j+1;i<n;i++)
                {
                    for(p=0;p<j;p++)
                    {
                        jm1[j][i]-=jm1[j][p]*jm1[p][i];
                    }
                    jm1[j][i]=jm1[j][i]/jm1[j][j];

                }
            }
            for(i=0;i<n;i++)
            {
                dX[i]=fsv[i];
                for(j=0;j<i;j++)
                {
                    dX[i]-=jm1[i][j]*dX[j];
                }
                dX[i]=dX[i]/jm1[i][i];
            }
            for(i=(n-1);i>=0;i--)
            {
                for(j=(i+1);j<n;j++)
                {
                    dX[i]=dX[i]-jm1[i][j]*dX[j];
                }
            }

            for(i=0;i<n;i++)
            {
                x[i]+=dX[i];
            }


            funk(x, fsv);
            System.out.printf("\nk=%d",k);
            for (i=0;i<n;i++)
                System.out.printf("\nx[%d]=%f, f[%d]=%f\n",i,x[i],i,fsv[i]);
            k++;
            tmp=0;
            for(i=0;i<n; i++)
                tmp+=dX[i]*dX[i];
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                {  jm[i][j]-=fsv[i]*dX[j]/tmp;
                }

            for(i=0;i<n;i++)
            {
                normx+=x[i]*x[i];
                normdx+=dX[i]*dX[i];
            }
            normx=Math.sqrt(normx);
            normdx=Math.sqrt(normdx);
        }
        while(normdx>normx*EPS);

    }

    public static void main(String[] args)
    {

        int n=2;
        float[] xv1 =new float[n];
        float EPS=0.00001f;

        xv1[0]=0.8f;
        xv1[1]=0.8f;
        System.out.printf("Start x1=%f,  x2=%f\n\n\n", xv1[0], xv1[1]);

        System.out.printf("\n\n\nNewton");
        newton(xv1, EPS, n);
        xv1[0]=0.8f;
		xv1[1]=0.8f;
		System.out.printf("\n\n\nSec");
        sichnyh(xv1, EPS, n);
    }
}

