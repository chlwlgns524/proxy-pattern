import cloudService.CloudDb;
import cloudService.CloudProxy;
import cloudService.CloudService;
import cloudService.File;

public class Main {

    public static void main(String[] args) {
        CloudService myCloud = new CloudProxy(new CloudDb());
        CloudService yourCloud = new CloudProxy(new CloudDb());

        try {
            ((CloudProxy)myCloud).login("test1", "test1");
            myCloud.upload("test1", new File("lala.txt"));
            System.out.println(myCloud.download("test1", "lala.txt"));
            System.out.println();

            ((CloudProxy)yourCloud).login("test2", "test2");
            yourCloud.upload("test2", new File("시험 요약본.pdf"));
            System.out.println(yourCloud.download("test2", "시험 요약본.pdf"));
            System.out.println();
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            ((CloudProxy)myCloud).logout();
            ((CloudProxy)yourCloud).logout();
        }
    }

}
