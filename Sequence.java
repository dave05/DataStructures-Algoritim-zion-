//  SEQUENCE. A sequence of BASEs represented by an array. If you compile this,
//  then you'll see these annoying messages.
//
//    Note: Sequence.java uses unchecked or unsafe operations.
//    Note: Recompile with -Xlint:unchecked for details.
//
//  Just ignore them. They're not bugs, they're features.

class Sequence<Base>
{
  private static final int defaultIncrement  = 10;  //  Default for INCREMENT.
  private static final int defaultMultiplier = 1;   //  Default for MULTIPLIER.
  private static final int defaultSize       = 10;  //  Default for SIZE.

  private int     count;       //  How many elements of OBJECTS we're using.
  private int     increment;   //  Add this many elements to OBJECTS.
  private int     multiplier;  //  Make OBJECTS this many times bigger.
  private Base [] objects;     //  The elements of the SEQUENCE.

//  Constructors. Each makes a new empty sequence, but in different ways.

  public Sequence()
  {
    objects = (Base []) new Object[defaultSize];
    count = 0;
  }

  public Sequence(int size)
  {
    this(size, defaultMultiplier, defaultIncrement);
  }

  public Sequence(int size, int multiplier, int increment)
  {
    if (size >= 0)
    {
      this.multiplier = multiplier;
      this.increment = increment;
      objects = (Base []) new Object[size];
      count = 0;
    }
    else
    {
      throw new IllegalArgumentException("Can't have negative size.");
    }
  }

//  IS EMPTY. Test if the SEQUENCE is empty.

  public boolean isEmpty()
  {
    return count == 0;
  }

//  IS FULL. Test if the SEQUENCE is full.

  public boolean isFull()
  {
    return count >= objects.length;
  }

//  ADD. Add a new OBJECT to the end of OBJECTS. Maybe make it bigger first.

  public void add(Base object)
  {
    if (isFull())
    {
      int newSize = multiplier * objects.length + increment;
      Base [] newObjects = (Base []) new Object[newSize];
      for (int index = 0; index < objects.length; index += 1)
      {
        newObjects[index] = objects[index];
      }
      objects = newObjects;
    }
    objects[count] = object;
    count += 1;
  }

//  FIND. Return the INDEX of the first appearance of OBJECT in OBJECTS, or -1.

  public int find(Base object)
  {
    if (object == null)
    {
      for (int index = 0; index < count; index += 1)
      {
        if (objects[index] == null)
        {
          return index;
        }
      }
    }
    else
    {
      for (int index = 0; index < count; index += 1)
      {
        if (object.equals(objects[index]))
        {
          return index;
        }
      }
    }
    return -1;
  }

//  LENGTH. Return the length of this SEQUENCE.

  public int length()
  {
    return count;
  }

//  REMOVE. Remove the object at INDEX from OBJECTS.

  public Base remove(int index)
  {
    if (0 <= index && index < count)
    {
      Base object = objects[index];
      while (index < count - 1)
      {
        objects[index] = objects[index + 1];
        index += 1;
      }
      count -= 1;
      objects[count] = null;
      return object;
    }
    else
    {
      throw new IllegalArgumentException("Index out of range.");
    }
  }

//  REMOVE. Remove the first appearance of OBJECT from OBJECTS.

  public void remove(Base object)
  {
    int index = find(object);
    if (index >= 0)
    {
      remove(index);
    }
  }

//  TO STRING. Turn this SEQUENCE into a STRING for printing.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    if (count > 0)
    {
      builder.append(objects[0]);
      for (int index = 1; index < count; index += 1)
      {
        builder.append(", ");
        builder.append(objects[index]);
      }
    }
    builder.append(']');
    return builder.toString();
  }
}

//  ARRAY HOORAY. Driver class. Make a SEQUENCE and test it. Maybe we need more
//  tests.

class ArrayHooray
{
  public static void main(String[] args)
  {
    Sequence<String> tzekwints = new Sequence<String>(4);
    System.out.println(tzekwints.isEmpty());  //  true

    tzekwints.add("A");
    tzekwints.add("B");
    tzekwints.add("C");
    tzekwints.add("D");
    System.out.println(tzekwints);  //  [A, B, C, D]

    tzekwints.add("E");
    System.out.println(tzekwints);  //  [A, B, C, D, E]

    tzekwints.remove("B");
    System.out.println(tzekwints);  //  [A, C, D, E]

    System.out.println(tzekwints.length());   //   4
    System.out.println(tzekwints.find("D"));  //   2
    System.out.println(tzekwints.find("φ"));  //  -1
  }
}
