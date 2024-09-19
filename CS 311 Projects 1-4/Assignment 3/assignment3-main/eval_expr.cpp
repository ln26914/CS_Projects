/**
 *Implementation of the functions to evaluate arithmetic expressions
 *The implementation should use the Stack data structure
 */
//You must complete the TODO parts and then complete LinkedList.cpp. Delete "TODO" after you are done.
//You should always comments to each function to describe its PURPOSE and PARAMETERS
#include "stack.h"
#include "eval_expr.h"
#include <iostream>
using namespace std;

/**
 *@brief Evaluate a postfix expression
 *@param postfix_expr The input expression in the postfix format.
 *@param result gets the evaluated value of the expression (by reference).
 *@return true if expression is a valid postfix expression and evaluation is done without error, otherwise false.
 */
bool evalPostfixExpr(string postfix_expr, float &result) {

	if(postfix_expr[0] == '\0') {
		return false;
	}
	
	Stack<float> operands = Stack<float>(4);
	int i = 0; //index
	char k = 0; //ith character of string.
	float a = 0; //operand. Other operand is result.
	while(postfix_expr[i] != '\0') {
		
		//Reset variables
		a = 0, k = 0;

		switch(postfix_expr[i]) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
				k = postfix_expr[i];
				a = k - 48;
				operands.push(a);
				
				break;
			case '*':

				if(i == 0) {
					//first character cannot be an operator.
					return false;
				}
				//Get our operands
				operands.pop(a);
				operands.pop(result);
				
				//Calculate
				result *= a;
				operands.push(result);
				
				//Continue
				break;
			case '/':

				if(i == 0) {
					//first character cannot be an operator.
					return false;
				}
				//Get our operands
				operands.pop(a);
				operands.pop(result);
				
				//Calculate
				result /= a;
				operands.push(result);

				//Continue
				break;
			case '+':
				if(i == 0) {
					//first character cannot be an operator.
					return false;
				}
				//Get our operands
				operands.pop(result);
				operands.pop(a);
				
				//Calculate
				result += a;
				operands.push(result);

				//Continue
				break;
			case '-':
				if(i == 0) {
					//first character cannot be an operator.
					return false;
				}
				//Get our operands
				operands.pop(a);
				operands.pop(result);
				
				//Calculate
				result -= a;
				operands.push(result);


				//Continue
				break;

			default:
				return false;
				break;	
		}
		i++;
	}
	return true;
}

bool evalPrefixExpression(string prefix_expr, float& result) {
	result = 0;
	return false;
}

/**
 *@brief Convert an infix expression to an equivalent postfix expression
 *@param infix_expr The input expression in the infix format.
 *@return the converted postfix expression. If the input infix expression is invalid, return an empty string "";
 */

//This almost certainly won't work.
string convertInfixToPostfix(string infix_expr)
{

    cout << "Infix Expression: " << infix_expr << endl;

    Stack<char> operators = Stack<char>(4);
    string postfix_expr = "";
    int i = 0; //Index of string
    char k = 0;
    while(infix_expr[i] != '\0') {

        k = 0;
        cout << "Current character: " << infix_expr[i] << endl;

        switch(infix_expr[i]) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                postfix_expr += infix_expr[i];
                cout << "Expression: " << postfix_expr << endl;
                break;
            case '(':
                operators.push(infix_expr[i]);
                operators.displayAll();
                break;
            case ')':
                while(!operators.isEmpty()) {
                    if(operators.top() != '(') {
                        operators.pop(k);
                        break;
                    }
                    operators.pop(k);
                    postfix_expr += k;
                }
                operators.displayAll();
                cout << "Expression: " << postfix_expr << endl;
                break;
            case '*':
            case '/':
                while(!operators.isEmpty()) {
                    if(operators.top() == '+' || operators.top() == '-') {
                        operators.pop(k);
                        postfix_expr += k;
                    } else {
                        break;
                    }
                }
                operators.push(infix_expr[i]);
                operators.displayAll();
                cout << "Expression: " << postfix_expr << endl;
                break;
            case '+':
            case '-':                   
                operators.push(infix_expr[i]);
                operators.displayAll();
                cout << "Expression: " << postfix_expr << endl;
                break;  
        }
        i++;
    }

    while(!operators.isEmpty()) {
        char c;
        operators.pop(c);
        postfix_expr += c;
    }

    return postfix_expr;
}

/**
 *@brief Evaluate an infix expression. It's converted to a postfix expression first and then evaluated
 *@param infix_expr The input expression in the infix format.
 *@param result gets the evaluated value of the expression (by reference).
 *@return true if expression is valid and evaluation is done without error, otherwise false.
 */
bool evalInfixExpr(string infix_expr, float &result)
{
	string expr = convertInfixToPostfix(infix_expr);
	result = evalPostfixExpr(expr, result);
	return result;
}

string convertInfixToPrefix(string infix_expr) {
	//Reverse the infix expression
	//Make every '(' as a ')' and vice versa
	//Convert expression to postfix form
	//Reverse the expression

	//Reverse string and invert parentheses
	int first = 0, last = infix_expr.length()-1;
	for(int i = 0; i < (infix_expr.length()/2); i++) {

		if(infix_expr[i] == '(') {
			infix_expr[i] = ')';
		} else if (infix_expr[i] == ')') {
			infix_expr[i] = '(';
		}
		swap(infix_expr[first],infix_expr[last]);
		first++, last--;
	}
	
	//Convert to postfix
	convertInfixToPostfix(infix_expr);

	//Reverse again
	for(int i = 0; i < (infix_expr.length()/2); i++) {
		swap(infix_expr[first], infix_expr[last]);
		last++, first--;
	}

	return infix_expr;
}
