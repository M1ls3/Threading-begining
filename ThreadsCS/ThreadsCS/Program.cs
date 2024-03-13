using System.Globalization;
using System.Threading.Tasks;

namespace ThreadsCS
{
    using System;
    using System.Threading;

    public class Program
    {
        private static bool _disposed = false;
        private static int _threadCounter = 0;

        public static void Main(string[] args) => Handler();

        public static void Handler()
        {
            int threadCount = 4;
            Thread[] threads = new Thread[threadCount];

            for (int i = 0; i < threadCount; i++)
            {
                threads[i] = new Thread(Epsilon);
                threads[i].Start(_threadCounter++);
            }

            Thread threadSigma = new Thread(Upsilon);
            threadSigma.Start();
        }

        public static void Epsilon(object threadNumber)
        {
            int threadIndex = (int)threadNumber;
            long eta = 0;
            while (!_disposed)
            {
                eta = eta + 2;
            }
            Console.WriteLine($"Thread {threadIndex}: {eta}");
        }

        public static void Upsilon()
        {
            Thread.Sleep(30000);
            _disposed = true;
            Console.ReadLine();
        }
    }

}