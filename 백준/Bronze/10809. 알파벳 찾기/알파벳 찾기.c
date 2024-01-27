#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	char str[101];
	int cnt[26];
	for (int i = 0; i < 26; i++)
	{
		cnt[i] = -1;
	}
	scanf("%s", str);
	for (int i = 0; i < strlen(str) + 1; i++)
	{
		if (cnt[str[i] - 'a'] != -1)continue;
		cnt[str[i] - 'a']=i;
	}
	for (int i = 0; i < 26; i++)
	{
		printf("%d ", cnt[i]);
	}
}