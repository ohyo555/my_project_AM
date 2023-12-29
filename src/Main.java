import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 == ");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.print("명령어 > ");
			String cmd = sc.nextLine().trim();

//			System.out.println(cmd.contains("article detail"));

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력하세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {
				System.out.println("==게시글 작성==");
				int id = lastArticleId + 1;
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

//				LocalDate day = LocalDate.now();
				LocalDateTime time = LocalDateTime.now();
				String now = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//				System.out.println(now);

				Article article = new Article(id, title, body, now);
				articles.add(article);
//				System.out.println(title + " / " + body);

				System.out.printf("%d번 글이 생성 되었습니다.\n", id);
				lastArticleId++;
			} else if (cmd.equals("article list")) {
				System.out.println("==게시글 목록==");
				if (articles.size() == 0) {
					System.out.println("아무것도 없어");
				} else {
					System.out.println("  번호  /  제목  ");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("  %4d  /   %s\n", article.getId(), article.getTitle());
						System.out.printf("  %4d  /   %s\n", article.getId(), article.getNow());
					}
				}
			} else if (cmd.contains("article detail") == true) {
//				System.out.println("dfjkd");
				for (int i = articles.size() - 1; i >= 0; i--) {

					Article article = articles.get(i);

					String id = Integer.toString(article.getId());

					if (cmd.contains(id) == true) {
						System.out.printf("번호 : %d\n", article.getId());
						System.out.printf("날짜 : %s\n", article.getNow());
						System.out.printf("제목 : %s\n", article.getTitle());
						System.out.printf("내용 : %s\n", article.getBody());
					}
					
				}
				
			} else {
				System.out.println("사용할 수 없는 명령어입니다");
			}
		}

		System.out.println("== 프로그램 끝 == ");
		sc.close();
	}
}

class Article {
	private int id;
	private String title;
	private String body;
	private String now;

	public Article(int id, String title, String body, String now) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.now = now;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}
}