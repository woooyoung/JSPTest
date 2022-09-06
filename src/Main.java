import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			if (cmd.equals("system exit")) {
				System.out.println("==프로그램 종료==");
				break;
			}

			if (cmd.equals("article write")) {
				int id = lastArticleId + 1;
				String regDate = Util.getNowDateStr();
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);

				articles.add(article);

				lastArticleId++;

				System.out.printf("%d 번 글이 %s 에 작성되었습니다.\n", article.id, article.regDate);
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}

				System.out.println("번호  /     날짜             /   제목");
				for (int i = articles.size() - 1; i >= 0; i--) {

					Article article = articles.get(i);

					System.out.printf("%d    /     %s      /    %s   \n", article.id, article.regDate, article.title);
				}
			} else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", cmd);
			}

		}
		sc.close();
	}
}

class Util {
	public static String getNowDateStr() {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date now = new Date();

		return sdf1.format(now);
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;

	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
}
