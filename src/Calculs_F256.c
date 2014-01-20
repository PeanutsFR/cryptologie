#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifndef PolyG
#define PolyG 0x187
#endif

typedef unsigned char uchar;
uchar Add_F256[256][256];
uchar Mul_F256[256][256];

// aucun argument à saisir en ligne de commande
int main (int argc, char * argv[]) {


  // calcule_add();
  // affiche_add();

  printf("\n\n");

  calcule_mul();
  affiche_mul();


}

// ------------ ADDITION ------------ //

// Calcule le tableau des additions
void calcule_add() {

  for (int i = 0; i<255; i++) {
    for (int j = 0; j<255; j++) {
      Add_F256[i][j] = i ^ j;
    }
  }
}

// Affiche le tableau des additions
void affiche_add() {

  printf("uchar Add_F256[256][256] = {\n");

  for (int i = 0; i<255; i++) {
    printf("// Addition par x =  %d \n", i);
    printf("{ ");
    for (int j = 0; j<254; j++) {
      printf("0x%02.2X, ", Add_F256[i][j]);
    }
    printf("0x%02.2X }\n", Add_F256[i][255]);
  }
  printf("}");
}

// ------------ MULTIPLICATION ------------ //

// Calcule le tableau des multiplications
void calcule_mul() {

  for (unsigned int i = 0; i<255; i++) {
    for (unsigned int j = 0; j<255; j++) {
      Mul_F256[i][j] = Mul_F2X(i, j);
    }
  }
}

unsigned int Mul_F2X(unsigned int A,unsigned int B) {

  unsigned int resultat = 0;
  int l,b;
  for(l=0;l<32;l++){
    b = (B>>l)&1;
    if(b==1)
      resultat = resultat ^ b * (A<<l);
  }
  return resultat;
}

// Affiche le tableau des multiplications
void affiche_mul() {

  printf("uchar Mul_F256[256][256] = {\n");

  for (int i = 0; i<255; i++) {
    printf("// Multiplication par x =  %d \n", i);
    printf("{ ");
    for (int j = 0; j<254; j++) {
      printf("0x%x, ", Mul_F256[i][j]);
    }
    printf("0x%x }\n", Mul_F256[i][255]);
  }
  printf("}");
}
