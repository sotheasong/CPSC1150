n = int(input("What is the value of n? "))

for i in range(1, n):
    for j in range(1, n-i):
        print(" ")
        j += 1
    for j in range(i, 1):
        print(j + " ")
        j -= 1
    print("\n")
