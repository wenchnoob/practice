import sys

args = sys.argv

if len(args) < 3:
    print("failed due to insufficient args")
    exit(1)

try:
    a = int(args[1])
    b = int(args[2])
    print(a + b)
except ValueError:
    print("program expects two numbers")
    exit(1)


