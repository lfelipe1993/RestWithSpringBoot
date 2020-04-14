package br.net.digitalzone;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.net.digitalzone.exception.UnsuportedMathOperationException;
import br.net.digitalzone.exception.util.Utils;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double sum = Utils.converToDouble(numberOne) + Utils.converToDouble(numberTwo);

		return sum;

	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double subtraction = Utils.converToDouble(numberOne) - Utils.converToDouble(numberTwo);

		return subtraction;

	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double sum = Utils.converToDouble(numberOne) * Utils.converToDouble(numberTwo);

		return sum;

	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		if (Utils.converToDouble(numberOne) == 0 || Utils.converToDouble(numberTwo) == 0) {
			throw new UnsuportedMathOperationException("Please set a value greater than zero");
		}

		Double sum = Utils.converToDouble(numberOne) / Utils.converToDouble(numberTwo);

		return sum;

	}

	@RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double sum = (Utils.converToDouble(numberOne) + Utils.converToDouble(numberTwo)) / 2;

		return sum;

	}

	@RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		if (!Utils.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		double sum = Math.sqrt(Utils.converToDouble(numberOne));

		return sum;

	}



}
