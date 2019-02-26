#include <stdio.h>
#include <math.h>

int main() {
	double array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	double result = 0;
	int i;
	for (i = 0; i < 10; i++) {
		result += sqrt(array[i]);
	}
	result /= 10;
	printf("%f\n", result);
	return 0;
}
