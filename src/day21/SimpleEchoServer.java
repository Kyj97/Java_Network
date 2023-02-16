package day21;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.StringTokenizer;
// IP 165.246.115.165 포트 20000

public class SimpleEchoServer implements Runnable {
    // 다중 접속 에코 서버
    private static Socket clientSocket;
    public SimpleEchoServer(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }
    public static void main(String[] args) {
        System.out.println("다중 접속 에코 서버");
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기 중.....");
                clientSocket = serverSocket.accept();
                SimpleEchoServer tes = new SimpleEchoServer(clientSocket);
                new Thread(tes).start();
            }
        } catch (IOException ex) {

        }
        System.out.println("다중 접속 에코 서버 종료");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " 스레드 접속");
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(clientSocket.getInetAddress().toString() + " " + Thread.currentThread() +" 클라이언트가 보낸 메세지 : " + inputLine);
                String[] values = inputLine.split(" ");
                int op1 = Integer.parseInt(values[0]);
                String op = (values[1]);
                int op2 = Integer.parseInt(values[2]);
                int result = switch (op) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "*" -> op1 * op2;
                    default -> Integer.parseInt("error");
                };
//                if (Objects.equals(op, "+")){result = op1 + op2;
//                    break;}
//                else if (Objects.equals(op, "-")) {result = op1 - op2;
//                    break;}
//                else if (Objects.equals(op, "*")) {result = op1 * op2;
//                    break;
//                }
//                else {result = Integer.parseInt("error");}
//                out.println(result);
                out.println(inputLine + "=" + result);

            }
            System.out.println(Thread.currentThread() +" 클라이언트가 종료됨"); }
        catch (IOException ex)
        {
            System.out.println("입출력 예외 발생!");
        }
    }
}