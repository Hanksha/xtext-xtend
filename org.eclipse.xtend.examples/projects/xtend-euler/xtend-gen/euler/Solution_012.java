/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler
 */
package euler;

import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 * 
 *     1: 1
 *     3: 1,3
 *     6: 1,2,3,6
 *    10: 1,2,5,10
 *    15: 1,3,5,15
 *    21: 1,3,7,21
 *    28: 1,2,4,7,14,28
 * 
 * We can see that 28 is the first triangle number to have over five divisors.
 * 
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * @see http://projecteuler.net/problem=12
 */
@SuppressWarnings("all")
public class Solution_012 {
  public static void main(final String[] args) {
    long triangle = 0L;
    long i = 1L;
    while (true) {
      {
        triangle = (triangle + i);
        i = (i + 1);
        long _numberOfDivisors = Solution_012.numberOfDivisors(triangle);
        boolean _greaterThan = (_numberOfDivisors > 500);
        if (_greaterThan) {
          InputOutput.<Long>println(Long.valueOf(triangle));
          return;
        }
      }
    }
  }
  
  public static long numberOfDivisors(final long triangle) {
    long max = Double.valueOf(Math.sqrt(triangle)).longValue();
    long result = 0L;
    long i = 1L;
    while ((i < max)) {
      {
        if (((triangle % i) == 0)) {
          result = (result + 2);
        }
        i = (i + 1);
      }
    }
    return result;
  }
}
