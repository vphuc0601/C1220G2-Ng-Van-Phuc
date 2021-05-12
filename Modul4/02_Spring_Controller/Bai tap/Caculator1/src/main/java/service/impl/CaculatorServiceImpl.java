package service.impl;

import org.springframework.stereotype.Service;
import service.CaculatorService;
@Service
public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public double caculator(double number1, double number2, String operator) throws Exception {
        double result = 0;
        switch (operator) {
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1 * number2;
                break;
            case "Division":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    throw new Exception("Mau so phai khac 0");
                }
        }
        return result;
    }
}
