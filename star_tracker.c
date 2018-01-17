/*
This program can read from the raw file and then 
write into the txt file with the star gray value 
and its postion information.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define height  1080
#define width   1920

typedef unsigned char  BYTE;    //

int main()
{
    FILE *fp = NULL;

    BYTE B[height][width];
    BYTE *ptr;

    char path[256];

    int i,j,k;
    int min,max;    //选取途中最大及最小的灰度值
    int sum;        //灰度值的总和
    int num;        //像素数
    double mtf;     //MTF，传递函数值
    double average; //the average of all the pixels

    sum=0;
    num=0;
    average=0;

    char sentence[1000];
    FILE *fptr;
    fptr = fopen("star_position.txt", "w");

    printf("Input the raw image path: ");
    scanf("%s",path);
    if((fp = fopen( path, "rb" )) == NULL)
    {
        printf("can not open the raw image " );
        return 0;
    }
    else
    {
        printf("read OK \n");
    }

    ptr = (BYTE*)malloc( width * height * sizeof(BYTE) );
    for( i = 0; i < height; i++ )
    {
        for( j = 0; j < width ; j ++ )
        {
            fread( ptr, 1, 1, fp );
            if(*ptr>0){
                B[i][j]= *ptr;  // 把图像输入到2维数组中,变成矩阵型式
                num++;
                fprintf(fptr,"%d %d %d\n", B[i][j],i,j);

                printf("%d  \n",B[i][j]);
                printf("%d %d \n",i,j);
            }
        }
    }
    //printf("%d \n",num);
    fclose(fptr);
    fclose(fp);

}
