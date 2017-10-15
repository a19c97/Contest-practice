# read input
num = int(input())
expressions = []
for i in range(num):
    expressions.append(input())

output = [None] * num

for i in range(num):
    # for j in range(10):
    #     exp = expressions[i].replace("?", str(j))
    #     exp = exp.replace("=", "==")
    #     print(exp)
    #     if eval(exp):
    #         output[i] = j
    #         break

    # parse operators and operands
    expr = {}
    op = ""
    opIndex = 0
    for j in range(len(expressions[i])):
        if expressions[i][j] == "*":
            op = "*"
            expr["opOne"] = expressions[i][0:j]
            opIndex = j
            break
        elif expressions[i][j] == "+":
            op = "+"
            expr["opOne"] = expressions[i][0:j]
            opIndex = j
            break
        elif expressions[i][j] == "-" and j != 0:
            op = "-"
            expr["opOne"] = expressions[i][0:j]
            opIndex = j
            break

    for j in range(len(expressions[i])):
        if expressions[i][j] == "=":
            expr["opTwo"] = expressions[i][opIndex+1:j]
            expr["result"] = expressions[i][j+1:]

    # print("Original expression: ")
    # print("opOne: " + expr["opOne"])
    # print("opTwo: " + expr["opTwo"])
    # print("result: " + expr["result"])

    # try 0 to 9 ???
    for k in range(10):
        # no leading zeros
        if (expr["opOne"][0] == "?" or expr["opTwo"] == "?") and k == 0:
            continue
        opOne = expr["opOne"].replace("?", str(k))
        opTwo = expr["opTwo"].replace("?", str(k))
        result = expr["result"].replace("?", str(k))
        if op == "*":
            if int(opOne) * int(opTwo) == int(result):
                output[i] = k
                break
        elif op == "+":
            if int(opOne) + int(opTwo) == int(result):
                output[i] = k
                break
        elif op == "-":
            if int(opOne) - int(opTwo) == int(result):
                output[i] = k
                break

# output answer
for i in range(num):
    if output[i] is None:
        print(-1)
    else:
        print(output[i])