import java.util.Arrays;

/**
 * This is the first sample program in Core Java Chapter 3
 * @version 1.01 1997-03-22
 * @author Gary Cornell
 */
public class FirstSample
{
   // local enums are not supported in Java8
   enum Size {S, M, L};

   public static void main(String[] args)
   {
      System.out.println("We will not use 'Hello, World!'");
      System.out.println();

      // >= Java 7, number literals 可以用_分隔
      int humanReadableInteger = 100_100;
      System.out.println("humanReadableInteger(100_100) = " + humanReadableInteger);
      System.out.println();

      // 16进制表示精度部分,以2位底,指数为10进制整数
      // hexadecimalFloatingPoint = (1 * 16 ** 1 + 1 * 16 ** 0 + 1 * 16 ** -1) * (2 ** -3)
      double hexadecimalFloatingPoint = 0X11.1p-3;
      System.out.println("hexadecimalFloatingPoint(0X11.1p-3) = " + hexadecimalFloatingPoint);
      System.out.println();

      // Double.POSITIVE_INFINITY Double.NEGATIVE_INFINITY Double.NaN
      // 不要用 == 比较,用isXxx函数代替
      boolean isInfinite = Double.isInfinite(1.0 / 0);
      if (isInfinite) {
         System.out.println("Double.isInfinite(1.0 / 0) = " + isInfinite);
      }
      System.out.println();

      // char: 'a', 1byte [\u0000, \uFFFF]
      // backslash u 编码可以直接用于Java代码, 例如:public static void main(String\u005B\u005D args)
      // 转移字符: \\, \', \"
      System.out.println("\\ \' \"");
      System.out.println();

      // unicode escape sequences的一些坑:
      // 1. 优先于代码被解释, 例如: "\u0022+\u0022" = "", \u0022 = "
      // 2. 注意换行, 例如: // \\u000A is a newline, \\u000A = \n(测试时请替换为一个backslash)
      // 3. backslash u后面必须跟4个16进制数, 例如: look inside c:\\users(测试时请替换为一个backslash)

      // code point: a code value that is associated with a character in an encoding scheme
      // unicode 17 code planes: [U+0000, U+FFFF], [U+010000, U+10FFFF]
      // code unit: [U+0000, U+FFFF]
      // code unit里面[U+DBFF, U+D800]&&[U+DFFF, U+DC00]是没有使用到的,用于supplementary characters的第一和第二个code unit
      // In Java, the char type describes a code unit in the UTF-16 encoding
      // 除非直接操作 UTF-16 code units,否则不建议使用char,可以直接用String代替

      String octonions = "\uD835\uDD46";
      // octonions 在UTF-16的 code point = U+1D546
      // octonions 的 code units = U+D835 U+DD46

      char octonionsCodeUnitChar1 = '\uD835';
      char octonionsCodeUnitChar2 = '\uDD46';

      System.out.println("octonions[String](" + octonions + ")(\"\\uD835\\uDD46\"), length: " + octonions.length() +"\n"
              + "  = " + ("blankString[String](\"\") + " + "octonionsCodeUnitChar1[char](" + octonionsCodeUnitChar1 + ")(" + "'\\uD835'" + ") + " + "octonionsCodeUnitChar2[char](" + octonionsCodeUnitChar2 + ")(" + "'\\uDD46'" + ")\n")
              + " != " + "octonionsCodeUnitChar1[char](" + octonionsCodeUnitChar1 + ")(" + "'\\uD835'" + ") + " + "octonionsCodeUnitChar2[char](" + octonionsCodeUnitChar2 + ")(" + "'\\uDD46'" + ")");
      System.out.println();

      // Java 的 int 和 boolean 不能自动转换

      // variable name = "letters" + "letters or digits"
      // letters: unicode中任意语言的 'A'–'Z', 'a'–'z', '_', '$'
      // digits: unicode中任意语言的'0'–'9'
      // Character.isJavaIdentifierStart: 是不是Java标识符
      // Character.isJavaIdentifierPart: 是不是Java非开头letter的标识符
      // 不要使用$
      // 无法使用未初始化的变量
      // final: 只可以赋值一次,一般用于常量

      // 使用 Math.floorMod(x, y), 不要使用 x % y, 虽然 y < 0 仍然会出现负余数

      // >>: 补充符号位
      // >>>: 补0
      int positiveTwo = 0b10;
      int negativeTwo = -positiveTwo;
      System.out.println(" 2       = " + "000000000000000000000000000000" + Integer.toBinaryString(positiveTwo));
      System.out.println("-2       = " + Integer.toBinaryString(negativeTwo));
      System.out.println("-1       = " + Integer.toBinaryString(-1));
      System.out.println("-2 >> 1  = " + Integer.toBinaryString(negativeTwo >> 1));
      System.out.println("-2 >>> 1 = " + "0" + Integer.toBinaryString(negativeTwo >>> 1));
      System.out.println();

      Size s = Size.S;
      Size l = Size.L;
      System.out.println("s = " + s + ", ordinal = " + s.ordinal());
      System.out.println("l = " + l + ", ordinal = " + l.ordinal());
      System.out.println();

      // s.equals(t): 字符串是否一致
      // s == t:      指针地址是否一致
      // only string literals are shared, not strings that are the result of operations
      // if (str != null && str.length() != 0)
      // String.length() method yields the number of code units required for a given string

      String eightCodeUnitsOrSevenCodePoints = "123\uD835\uDD46678";
      System.out.println("123\uD835\uDD46678, codeUnitCount = " + eightCodeUnitsOrSevenCodePoints.length());
      System.out.println("123\uD835\uDD46678, codePointCount = " + eightCodeUnitsOrSevenCodePoints.codePointCount(0, eightCodeUnitsOrSevenCodePoints.length()));

      // get at the ith code point
      // int offsetByCodePoints(int startIndex,int cpCount)
      // 其实就是取 第 startIndex + cpCount 个 code point 的 code unit 的 index
      int index = eightCodeUnitsOrSevenCodePoints.offsetByCodePoints(3, 1);
      System.out.println("eightCodeUnitsOrSevenCodePoints.offsetByCodePoints(3, 1) index = " + index);
      index = eightCodeUnitsOrSevenCodePoints.offsetByCodePoints(3, 0);
      int cp = eightCodeUnitsOrSevenCodePoints.codePointAt(index);
      // code point 2 char[]: new char[] {'\uD835', '\uDD46'}
      System.out.print("\uD835\uDD46's code point 2 char[]: ");
      System.out.println(Character.toChars(cp));
      System.out.println();

      /*
      if (Character.isSupplementaryCodePoint(cp))
      {
         i += 2;
      } else {
         i++;
      }

      i--;
      if (Character.isSurrogate(sentence.charAt(i))) i--;
      int cp = sentence.codePointAt(i);
      */

      // String 和 code points 之间的转换
      // int[] codePoints = str.codePoints().toArray();
      // String str = new String(codePoints, 0, codePoints.length);
      StringBuilder builder = new StringBuilder();
      builder.append('B');
      builder.append(": Builder");
      System.out.println("builder = " + builder.toString());
      System.out.println();

      // switch: char, byte, short, int, enum(no need to use Enum.constant), string literal

      // java.math.BigInteger / java.math.BigDecimal

      String[] strings;
      strings = new String[3];
      System.out.println("length of new String[3] = " + strings.length);
      System.out.print("new String[3] = [");
      for (String ss: strings) {
         System.out.print(ss + ", ");
      }
      System.out.println("]");
      System.out.println("Arrays.toString(new String[3]) = " + Arrays.toString(strings));

      // ERROR!!! array = {1, 2, 3};
      int[] array = {1, 2, 3};
      array = new int[] {2, 3, 4};
      array = new int[]{};
      System.out.println("length of new int[]{}(! = null) = " + array.length);
   }
}
